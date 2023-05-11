package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.entity.ReceiptDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDetailsRepository extends JpaRepository<ReceiptDetails, Integer> {
}
