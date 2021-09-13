package com.toll.etrservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-10T23:13:29.151519600-04:00[America/Toronto]")

@Controller
@RequestMapping("${openapi.eTR407TollCalculatorService.base-path:}")
public class TollCalculatorServiceApiController implements TollCalculatorServiceApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TollCalculatorServiceApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
