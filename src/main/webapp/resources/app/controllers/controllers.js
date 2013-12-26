app.controller('CompanyController', function ($scope, CompanyService) {
    init();

    function init() {
        $scope.companies = CompanyService.getCompanies();
    }

    $scope.insertCompany = function () {
        var name = $scope.newCompany.name;
        var phone = $scope.newCompany.phone;
        var website = $scope.newCompany.website;

        CompanyService.insertCompany(name, phone, website);

        $scope.newCompany.name = '';
        $scope.newCompany.phone = '';
        $scope.newCompany.website = '';
    };

    $scope.deleteCompany = function (id) {
        CompanyService.deleteCompany(id);
    };

});

app.controller('JobController', function ($scope, JobService, CompanyService) {
    init();

    function init() {
        $scope.newJob = {};
        $scope.jobs = JobService.getJobs();
        $scope.companies = CompanyService.getCompanies();
        $scope.jobPredicate = 'lastModified';
        $scope.jobSortOrderIsAscending = false;
    }

    $scope.sort = function (predicate) {
        $scope.jobPredicate = predicate;
        $scope.jobSortOrderIsAscending = !$scope.jobSortOrderIsAscending;
    }


    $scope.createNewJob = function () {
        var now = new Date().toJSON().toString();
        var property = $scope.newJob.selectedProperty;
        var created = now;
        var lastModified = now;
        var contact = $scope.newJob.selectedContact;
        var company = $scope.newJob.selectedCompany;

        JobService.insertJob(property, created, lastModified, contact, company);

        $scope.newJob = {};
    }

    $scope.showJobModal = function(job) {
        console.log(job);

    }

    $scope.newJob.formIsntComplete = function () {
        return !($scope.newJob.selectedCompany && $scope.newJob.selectedContact && $scope.newJob.selectedProperty);
    }
});