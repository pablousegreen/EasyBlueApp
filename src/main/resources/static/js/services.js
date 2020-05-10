/**
 * SERVICE
 */

	 
angular.module('filmFactory', []).factory('filmsFactory', function( $http){
	
	let getAllFillms = async() => {
		let results = await $http.get('/films').success(function(data) {
			return data;
		});
		return results.data;
	}
	
	return {
			list : getAllFillms,
			saveFilm : async (film) => {
				return await $http.post('/films', 
						{
							title : film.title,
							year : film.year,
							director : film.director
						}
					).success( async(data) => {
						return data; 
						
					}).error(async function(data){
						return data;
					});
			}
		}//return
});