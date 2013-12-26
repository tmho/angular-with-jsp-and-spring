var app = angular.module('smartaApp', ['ngRoute']);

//This configures the routes and associates each route with a view and a controller
app.config(function ($routeProvider) {
    $routeProvider
        .when('/companies',
        {
            controller: 'CompanyController',
            templateUrl: '/resources/app/partials/company_fragment.html'
        })
        .when('/jobs',
        {
            controller: 'JobController',
            templateUrl: '/resources/app/partials/job_fragment.html'
        })
        .otherwise({ redirectTo: '/jobs' });
});




