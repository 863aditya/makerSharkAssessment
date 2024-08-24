package makershark.SupplierManufacturing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierManufacturingRepository extends JpaRepository<SupplierManufacturing,Long> {

    @Query(value="SELECT manufacturing_id from supplier_manufacturing as x where x.supplier_id = :supplierId",nativeQuery = true)
    List<Long> findManufacturingIdBySupplierId(@Param("supplierId") Long supplierId);
}
