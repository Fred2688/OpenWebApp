angular.module('LoginApp', [])
.controller('LoginCtrl', function($scope, user, $window) {

	$scope.user = {

			//fonction qui permet de vérifier si l'utilisateur à rentrer le bon login/mdp
			authentification :  function() {

				/*Promise qui implemente des fonctions de callbacks en cas de succès ou d'echec de la
				fonction d'authentification
				*/
				user.checkUser($scope.userName, $scope.userPassword).then(
						// success
						function(response) {
							if(response.data==true){
								//redirige sur la page des alcools en cas de succes
								$window.location.href = '/alcohol.html';
							}
						},
						// failure
						function(data) {
						}
				);
			}
	}

})
/*Le provider sert à cloisonner les appels au controller*/
.provider('user', function UserProvider() {

	this.$get = function($http) {

		return {

			/*Fait une requête http post sur /user/login avec le login et le mdp en paramètre pour vérifier si
			l'utilisateur s'est bien authentifié */
			checkUser: function(name, password) {

				return $http.post('/user/login', {name: name, password: password})
			}
		};
	};
});
