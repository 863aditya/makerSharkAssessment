package makershark.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    @Query(value="SELECT s.id,s.company_name,s.website,s.location " +
            "FROM manufacturing m, supplier_manufacturing sm, supplier s " +
            "WHERE m.process = :process AND m.id=sm.manufacturing_id AND s.location= :location and s.id=sm.supplier_id;",nativeQuery = true)

    public List<Supplier> getSupplierByManufacturingIdAndProcess(@Param("process") String process, @Param("location") String location);
}
