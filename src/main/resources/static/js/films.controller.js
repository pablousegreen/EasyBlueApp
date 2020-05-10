/**
 * CONTROLLER
 */
	var filsmController = angular.module('filmController', []);
	
	filsmController.controller('FilmsController', function($scope, $http, filmsFactory) {
		//$scope.filmsList = [];
		$scope.title = "";
		$scope.year = 2020;
		$scope.director = "";
		
		   $scope.getFilms =  async() =>{
			   $scope.filmsList = await filmsFactory.list();
			   $scope.$apply();
			}
			
			$scope.addFilm = async () => {
				console.log('Were gonna see all films--');
				let res = await filmsFactory.saveFilm( 
						{
							title : $scope.title,
							year : $scope.year,
							director : $scope.director
						});	
				if(res.status == 200){
					$scope.msg = 'Movie saved successfully';
				}else{
					$scope.msg = 'Movie not saved, something was bad..';
				}
				$scope.getFilms();
			}
			
			
			
	} );