package com.cifolavioleta.springbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cifolavioleta.springbackend.model.*;

import com.cifolavioleta.springbackend.repository.*;

@Configuration
public class LoadTestData {
    private static final Logger log = LoggerFactory.getLogger(LoadTestData.class);

    // precarga de libros y citas
    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository, QuoteRepository quoteRepository) {
        return args -> {
        	log.info("Cleaning previous book data");
        	bookRepository.deleteAll();
        	
            log.info("Preloading book " + bookRepository.save(new Book(null, "Anna Karenina")));
            log.info("Preloading book " + bookRepository.save(new Book(null, "Orlando")));
            
        	log.info("Cleaning previous quote data");
        	quoteRepository.deleteAll();
           
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "Happy families", "“All happy families are alike; each unhappy family is unhappy in its own way.", 14)));
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "Perfection", "If you look for perfection, you'll never be content.", 10)));
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "Hearts", "I think... if it is true that there are as many minds as there are heads, then there are as many kinds of love as there are hearts.", 28)));
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "The sun", "He stepped down, trying not to look long at her, as if she were the sun, yet he saw her, like the sun, even without looking.", 26)));
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "Respect", "Respect was invented to cover the empty place where love should be.", 12)));
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "Woman thinking", "As long as she thinks of a man, nobody objects to a woman thinking.", 14)));
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "Melancholy", "Nothing thicker than a knife's blade separates happiness from melancholy.", 11)));
            log.info("Preloading quote " + quoteRepository.save(new Quote(null, "Woman existence", "Love, the poet said, is woman's whole existence.", 9)));
        };
    }
}