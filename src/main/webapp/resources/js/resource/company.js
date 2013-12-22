var companyService = angular.module("companyService", ["ngResource"]);

companyService.factory("Company", function ($resource) {
    return $resource(
        "/api/company/:id", {id: "@id" }, {}
    );
});