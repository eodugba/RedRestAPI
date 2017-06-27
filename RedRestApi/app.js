redRestAPI.config(function ($routeProvider) 
             { $routProvider
                 .when('/Login', 
                       {
                         templateUrl: 'js/login.html',
                         controller: 'LoginController'
                       }
                      )
                 .when('/user/{user}/visits', 
                       {
                         templateUrl:  'js/visits-list.html',
                         controller: 'visitsListController'
                       }
                      )
                 .otherwise(
                       {
                         redirectTo: '/login'
                       }
                      );
               }
 );
 
 