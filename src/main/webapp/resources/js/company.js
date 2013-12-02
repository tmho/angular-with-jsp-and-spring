if (typeof(Company) === "undefined")
{
    Company = {};
};

Company.getAllSuccess = function (data) {
    $('#company_list').html('');
    for (var i in data) {
        $('#company_list').append('<p>' + data[i].name + '</p>');
    }
}

Company.getAllFailure = function () {
    console.log('company.getAll failed');
}
