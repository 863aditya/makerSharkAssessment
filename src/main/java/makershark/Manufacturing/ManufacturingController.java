package makershark.Manufacturing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturing")
public class ManufacturingController {
    @Autowired
    private ManufacturingRepository repository;

    @PostMapping
    public Manufacturing createManufactruring(@RequestBody Manufacturing manufacturing){
        return repository.save(manufacturing);
    }

    @GetMapping
    public List<Manufacturing> getAll(){
        return repository.findAll();
    }


}
