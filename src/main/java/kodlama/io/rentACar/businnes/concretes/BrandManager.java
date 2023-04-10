package kodlama.io.rentACar.businnes.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.businnes.abstracts.BrendService;
import kodlama.io.rentACar.businnes.requests.CreateBrandRequest;
import kodlama.io.rentACar.businnes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.businnes.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.businnes.responses.GetByIdBrandsResponse;
import kodlama.io.rentACar.businnes.rules.BrandBusinnesRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service //bu sınıf bir businnes nesnesidir
@AllArgsConstructor
public class BrandManager implements BrendService {
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinnesRules  brandBusinnesRules;
	







	@Override
	public List<GetAllBrandsResponse> getAll() {
		//iskuralları
		
		List<Brand> brands=brandRepository.findAll();
		
		
		List<GetAllBrandsResponse> brandsResponse=brands.stream().map(brand->this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return brandsResponse;
		
		

	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		
		this.brandBusinnesRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand=this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);			
		
		
        this.brandRepository.save(brand);
		
	}





	@Override
	public GetByIdBrandsResponse getById(int id) {
	 Brand brand=  this.brandRepository.findById(id).orElseThrow();
	 
	 GetByIdBrandsResponse  getByIdBrandsResponse
	 =this.modelMapperService.forResponse().map(brand, GetByIdBrandsResponse.class);
		return getByIdBrandsResponse;
	}





	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
          Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
          
          this.brandRepository.save(brand);
	}





	@Override
	public void delete(int id) {
   this.brandRepository.deleteById(id);		
	}
	
	

}
