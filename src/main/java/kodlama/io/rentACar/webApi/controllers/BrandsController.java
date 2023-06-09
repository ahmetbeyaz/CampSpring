package kodlama.io.rentACar.webApi.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.rentACar.businnes.abstracts.BrendService;
import kodlama.io.rentACar.businnes.requests.CreateBrandRequest;
import kodlama.io.rentACar.businnes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.businnes.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.businnes.responses.GetByIdBrandsResponse;


@Controller
@RestController 
@RequestMapping("api/brands")
public class BrandsController {

	private BrendService brendService;

	@Autowired
	public BrandsController(BrendService brendService) {
		super();
		this.brendService = brendService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		return brendService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public GetByIdBrandsResponse getByIdBrandsResponse(@PathVariable int id) {
		return this.brendService.getById(id);
		
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody()  @Valid()   CreateBrandRequest createBrandRequest) {
		 this.brendService.add(createBrandRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody()  UpdateBrandRequest updateBrandRequest) {
		
		this.brendService.update(updateBrandRequest);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		
		this.brendService.delete(id);
	}

}
