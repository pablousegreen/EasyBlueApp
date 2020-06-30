package com.easyblueapp.secureapp.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public enum EnumCatsKeys {
	
	GENERIC,
	APPLE(CategoriesEnum.APPLE),
	WIN(CategoriesEnum.WIN),
	BRAND_APPLE("APPLE"),
	BRAND_WIN("WIN");
	
	private Optional<Map<String, List<String>>> resultCategoriesMap;
	private String brand;
	
    EnumCatsKeys(CategoriesEnum resultCategoriesMap) {
		this.resultCategoriesMap = resultCategoriesMap.getCategories();
	}
    
    EnumCatsKeys(String brand) {
    	this.brand = brand;
    }
    
    EnumCatsKeys() {
		// TODO Auto-generated constructor stub
	}

	public Optional<Map<String, List<String>>> getBrandsCategories(){
    	return resultCategoriesMap;
    }
	
    public Optional<String> getBrand(){
    	return Optional.of(this.brand);
    }
	
	
	public enum CategoriesEnum {
				
		APPLE("levels", Arrays.asList("basic", "standard", "plus")),  
		WIN("levels", Arrays.asList("basicWin", "plusWIn"));
		
		private Map<String, List<String>> resultCategories = new HashMap<>();
		
		CategoriesEnum(String categoryOne, List<String> categoryTwo){
			resultCategories.put(categoryOne, categoryTwo);
		}
		
		public Optional<Map<String, List<String>>>getCategories(){
			return Optional.ofNullable(resultCategories);
		}
			
	}

}
