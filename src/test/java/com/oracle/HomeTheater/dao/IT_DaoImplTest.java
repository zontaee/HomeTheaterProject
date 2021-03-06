package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.model.Movie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IT_DaoImplTest {
@Autowired
IT_Dao it_dao;
    @Test
    void findMovieInfoDate() {
        List<Movie> movieInfoDate = it_dao.findMovieInfoDate(1);
        int checkMonumber = movieInfoDate.get(0).getSeatandTime().get(0).getMo_number();
        Assertions.assertThat(1).isEqualTo(checkMonumber);
    }
}