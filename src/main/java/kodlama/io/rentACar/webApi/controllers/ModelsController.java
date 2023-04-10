package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.businnes.abstracts.ModelService;
import kodlama.io.rentACar.businnes.requests.CreateModelRequest;
import kodlama.io.rentACar.businnes.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(name = "/api/models")
@AllArgsConstructor
public class ModelsController {
	
	private ModelService modelService;
	
	
	
	@GetMapping("/getAll")
	public List<GetAllModelsResponse>  getAll(){
		
		return this.modelService.getAll();
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid()  CreateModelRequest createModelRequest) {
		
		this.modelService.add(createModelRequest);
	}

}
