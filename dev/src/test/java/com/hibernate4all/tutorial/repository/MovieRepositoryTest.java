package com.hibernate4all.tutorial.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hibernate4all.tutorial.config.PersitenceConfig;
import com.hibernate4all.tutorial.domain.Movie;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PersitenceConfig.class})
@SqlConfig(dataSource = "dataSourceH2",transactionManager ="transactionManager")
@Sql({ "/datas/datas-test.sql" })
public class MovieRepositoryTest {
	@Autowired
	private MovieRepository repository;
	
	@Test
	public void save_casNominal() {
		Movie movie=new Movie();
		movie.setName("Inception");
		repository.persist(movie);
	}
	
	@Test
	public void find_casNominal() {
		Movie memento = repository.find(-2L);
		assertThat(memento.getName()).as("mauvais film recupere").isEqualTo("Memento");
		
	}
	
	@Test
	public void getAll_casNominal() {
		List<Movie> movies = repository.getAll();
		assertThat(movies).as("l ensemble des films n a pas ete recupere").hasSize(2);
		
	}

}
