package kodlama.io.rentACar.businnes.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinnessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinnesRules {
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		
		if(this.brandRepository.existsByName(name)) {
			
			throw new BusinnessException("Brand name already exists");
			
			
		}
		
	}

}
