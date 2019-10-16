package com.akash.autowiring.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("offersDao")
public class OffersDAO {
    /*private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDatasource(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    List<Offers> getOffers()
    {
        return jdbcTemplate.query("select * from offers", new RowMapper<Offers>() {
        public Offers mapRow(ResultSet resultSet, int i) throws SQLException {
            Offers offers=new Offers();
            offers.setIdoffers(resultSet.getInt("idoffers"));
            offers.setName(resultSet.getString("name"));
            offers.setEmail(resultSet.getString("email"));
            offers.setText(resultSet.getString("text"));
            return offers;
        }
    });
    }*/


    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    public void setDatasource(DataSource datasource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(datasource);
    }
/*  get Offers query using MapSqlParameterSource  */

    List<Offers> getOffers() {

      /*  MapSqlParameterSource params=new MapSqlParameterSource();
        params.addValue("name","akash");*/

        return jdbcTemplate.query("select * from offers", new RowMapper<Offers>() {
            public Offers mapRow(ResultSet resultSet, int i) throws SQLException {
                Offers offers = new Offers();
                offers.setIdoffers(resultSet.getInt("idoffers"));
                offers.setName(resultSet.getString("name"));
                offers.setEmail(resultSet.getString("email"));
                offers.setText(resultSet.getString("text"));
                return offers;
            }
        });
    }

    Offers getOffer(int id)
    {
        MapSqlParameterSource parameterSource=new MapSqlParameterSource();
        parameterSource.addValue("idoffers",id);
      return   jdbcTemplate.queryForObject("select * from offers where idoffers=:idoffers", parameterSource, new RowMapper<Offers>() {
          public Offers mapRow(ResultSet resultSet, int i) throws SQLException {
              Offers offers = new Offers();
              offers.setIdoffers(resultSet.getInt("idoffers"));
              offers.setName(resultSet.getString("name"));
              offers.setEmail(resultSet.getString("email"));
              offers.setText(resultSet.getString("text"));
              return offers;

          }
      });
    }

    public boolean delete(int id)
    {
        MapSqlParameterSource parameterSource=new MapSqlParameterSource("idoffers",id);
        return jdbcTemplate.update("delete from offers where idoffers=:idoffers",parameterSource)==1;
    }
    public boolean create(Offers offers)
    {
        BeanPropertySqlParameterSource params=new BeanPropertySqlParameterSource(offers);
        return jdbcTemplate.update("insert into offers(name,email,text) values(:name,:email,:text)",params)==1;
    }

}
