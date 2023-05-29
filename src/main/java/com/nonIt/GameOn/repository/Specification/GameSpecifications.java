package com.nonIt.GameOn.repository.Specification;

import com.nonIt.GameOn.entity.Game;
import org.springframework.data.jpa.domain.Specification;

import java.util.function.Predicate;

public class GameSpecifications {
    public static Specification<Game> systemReqContains(String req) {
        return (book, cq, cb) -> cb.like(book.get("systemReq"), "%" + req + "%");
    }

    public static Specification<Game> priceLessThanEqual(Double price) {
        return (book, cq, cb) -> cb.lessThanOrEqualTo(book.get("price"), price);
    }
}
