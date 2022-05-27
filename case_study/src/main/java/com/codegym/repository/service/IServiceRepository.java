package com.codegym.repository.service;

import com.codegym.dto.Booking;
import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findAllByServiceNameContaining(String name, Pageable pageable);

    @Query(value = "select customer_name as 'customerName', end_day as 'endDay'  , start_day as 'startDay', quantity as 'quantity', group_concat(attach_service_name) as 'attachServiceName', sum(service.service_cost+(contract_detail.quantity*attach_service_cost))\n" +
            "    as `total` from customer join contract on customer.customer_id = contract.customer_id\n" +
            "    join contract_detail on contract.contract_id  = contract_detail.contract_id join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id\n" +
            "    join service on service.service_id= contract.service_id\n" +
            "    group by contract.contract_id",nativeQuery = true)


    List<Booking> findBooking();



}
