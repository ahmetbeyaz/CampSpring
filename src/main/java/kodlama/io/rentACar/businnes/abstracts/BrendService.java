package kodlama.io.rentACar.businnes.abstracts;

import java.util.List;

import kodlama.io.rentACar.businnes.requests.CreateBrandRequest;
import kodlama.io.rentACar.businnes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.businnes.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.businnes.responses.GetByIdBrandsResponse;

public interface BrendService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandsResponse  getById(int id);
	
	void add(CreateBrandRequest createBrandRequest);
	
	void update(UpdateBrandRequest updateBrandRequest);
	
	void delete(int id);
	

	

}
