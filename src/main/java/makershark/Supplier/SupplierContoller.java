package makershark.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierContoller {

    @Autowired
    private SupplierRepository repository;

    @GetMapping("/first")
    public ResponseEntity<String> first(){
        return new ResponseEntity<>("HelloWorld", HttpStatus.OK);
    }

    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier){
        return repository.save(supplier);
    }

    @GetMapping
    public List<Supplier> getAllSupplier(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSupplier( @PathVariable Long id, @RequestBody Supplier supplierDetails) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));

        supplier.setCompanyName(supplierDetails.getCompanyName());
        supplier.setWebsite(supplierDetails.getWebsite());
        supplier.setLocation(supplierDetails.getLocation());

        repository.save(supplier);
        return ResponseEntity.ok("Supplier updated successfully!");
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<Supplier> getById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    @RequestMapping("/query")
    public List<Supplier> getResutlForQuery(@RequestParam(required = true,defaultValue = "DEFAULT") String location,
                                                                @RequestParam(required = true,defaultValue = "DEFAULT") String process){
        return repository.getSupplierByManufacturingIdAndProcess(process,location);
    }

}
