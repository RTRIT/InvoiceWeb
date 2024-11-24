package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.VendorAddress;


@Repository
public interface VendorAddressRepository extends JpaRepository<VendorAddress, Long> {

}
