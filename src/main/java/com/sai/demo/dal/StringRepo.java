package com.sai.demo.dal;

import com.sai.demo.model.PalindromeString;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringRepo extends JpaRepository<PalindromeString,Integer> {
}
