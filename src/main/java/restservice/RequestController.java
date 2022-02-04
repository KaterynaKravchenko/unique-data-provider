package restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restservice.handlers.DataRepository;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RequestController {
    private final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private DataRepository repository;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/getData")
    public String getData() {
        String text = repository.getData();
        logger.info("[INFO] Unique data was taken from list: " + text);
        return text;
    }

    @PostMapping()
    public String returnData(@RequestParam(value = "data") String text) {
        repository.returnData(text);
        logger.info("[INFO] Data was returned to list: " + text);
        return "ok";
    }

    @GetMapping("/getSet")
    public String getDataSet() {
        return repository.toString();
    }

}
