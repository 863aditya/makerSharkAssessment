package makershark.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public Supplier createSupplier(Supplier supplier){
        return repository.save(supplier);
    }

}
