package makershark.SupplierManufacturing;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplierManufacturing")
public class SupplierManufacturingController {
    @Autowired
    private SupplierManufacturingRepository repository;

    @PostMapping
    public SupplierManufacturing create(@RequestBody SupplierManufacturing supplierManufacturing){
        return repository.save(supplierManufacturing);
    }

    @GetMapping
    public List<SupplierManufacturing> getAll(){
        return repository.findAll();
    }

    @GetMapping
    @RequestMapping("/query/{id}")
    public List<Long> getManufacturingIdBySupplyId(@PathVariable Long id){
        return repository.findManufacturingIdBySupplierId(id);
    }
}
