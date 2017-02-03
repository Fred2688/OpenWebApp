angular.module('AlcoholApp', [])
.controller('AlcoholCtrl', function($scope, alcohol) {
	$scope.alcohol = {
			list: [],
			selected: null,
			idTemp : null,
			selectAlcohol: function(alcoholId) {
				$scope.alcohol.selected = alcoholId;
			},

			/*Retourne la liste des boissons de l'alcool correspondant à l'id passé en paramètre */
			getDrinkList: function(alcoholId) {

				for(var i=0; i < $scope.alcohol.list.length; i++) {
					if($scope.alcohol.list[i].id == alcoholId) {

						return $scope.alcohol.list[i].drinklist
					}
				}

				return [];
			},

			/*Promise qui implemente des fonctions de callbacks lors du retour de la fonction addAlcohol*/
			'newAlcohol': function() {
				alcohol.addAlcohol($scope.newAlcoholName).then(
						// success
						function(response) {
							//met à jour la liste des alcools
							response.data.drinklist = [];
							$scope.alcohol.list.push(response.data);
							$scope.newAlcoholName = "";
						},
						// failure
						function(data) {

						}
				);
			},

			'newDrink': function() {
				$scope.alcohol.idTemp = $scope.alcohol.selected;

				alcohol.addDrink($scope.newDrinkName, $scope.alcohol.selected).then(
						// success
						function(response) {
							//met à jour les listes de boissons de l'alcool selectionné
							var list = $scope.alcohol.getDrinkList($scope.alcohol.selected);
							list.push(response.data);
							$scope.newDrinkName = "";


						},
						// failure
						function(data) {

						}
				);
			}
	};
	
	/*Permet d'afficher la liste d'alcool en fonction de la db*/
	alcohol.getAlcoholList().then(
			// success
			function(response) {
				$scope.alcohol.list = response.data;
			},
			// failure
			function(data) {

			}
	);

})
/*Le provider sert à cloisonner les appels au controller*/
.provider('alcohol', function AlcoholProvider() {

	this.$get = function($http) {

		return {
			getAlcoholList: function() {
				return $http.get('/alcohol/');
			},

			addAlcohol: function(name) {
				return $http.post('/alcohol/', {name: name})
			},

			addDrink: function(name, alcoholId) {
				return $http.post('/alcohol/'+alcoholId+'/drink', {name: name})
			}
		};
	};
});

