package kodlama.io.rentACar.businnes.abstracts;

import java.util.List;

import kodlama.io.rentACar.businnes.requests.CreateModelRequest;
import kodlama.io.rentACar.businnes.responses.GetAllModelsResponse;

public interface ModelService {
	
	List<GetAllModelsResponse>  getAll();
	 
	void add(CreateModelRequest createModelRequest);			
	
	

}
