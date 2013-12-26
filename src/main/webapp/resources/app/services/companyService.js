app.service('CompanyService', function () {
    this.getCompanies = function () {
        return companies;
    };

    this.insertCompany = function (name, phone, website) {
        var topID = companies.length + 1;
        companies.push({
            name: name,
            phone: phone,
            website: website
        });
    };

    this.deleteCompany = function (id) {
        for (var i = companies.length - 1; i >= 0; i--) {
            if (companies[i].id === id) {
                companies.splice(i, 1);
                break;
            }
        }
    };

//    this.getCustomer = function (id) {
//        for (var i = 0; i < customers.length; i++) {
//            if (customers[i].id === id) {
//                return customers[i];
//            }
//        }
//        return null;
//    };

    var companies = [
        {
            id: 1,
            name: "tmho pty ltd",
            phone: "0311111111",
            website: "http://www.timosmond.com",
            staff: [
                {
                    id:1,
                    firstName: "Tim",
                    surname: "Lindley",
                    mobile: "0411111111",
                    email: "tlindly@timosmond.com",
                    role: "MANAGER"
                },
                {
                    id:2,
                    firstName: "Peter",
                    surname: "Parker",
                    mobile: "0422222222",
                    email: "pparker@timosmond.com",
                    role: "RECEPTION"
                },
                {
                    id:3,
                    firstName: "Spiderman",
                    surname: "Batman",
                    mobile: "0433333333",
                    email: "spiderman@timosmond.com",
                    role: "CEO"
                }
            ],
            properties: [
                {
                    id:1,
                    address:"4 Casuarina Drive, Frankston 3199",
                    strataNumber: "PS1234"
                },
                {
                    id:2,
                    address:"21 Grassland Ave, Coburg 3058",
                    strataNumber: "PS4321"
                }
            ]
        },
        {
            id: 2,
            name: "kato pty ltd",
            phone: "0322222222",
            website: "http://www.kingsleyosmond.com",
            staff: [
                {
                    id:4,
                    firstName: "Tom",
                    surname: "Riddle",
                    mobile: "0455555555",
                    email: "triddle@kingsleyosmond.com",
                    role: "MANAGER"
                },
                {
                    id:5,
                    firstName: "Harry",
                    surname: "Potter",
                    mobile: "0466666666",
                    email: "hpotter@kingsleyosmond.com",
                    role: "RECEPTION"
                },
                {
                    id:6,
                    firstName: "Hermione",
                    surname: "Granger",
                    mobile: "0477777777",
                    email: "hgranger@kingsleyosmond.com",
                    role: "CEO"
                }
            ],
            properties: [
                {
                    id:3,
                    address:"16 Allison Road, Mount Eliza 3930",
                    strataNumber: "PS9876",
                    manager:"Tom Riddle"
                }
            ]
        },
        {
            id: 3,
            name: "rjfo pty ltd",
            phone: "0333333333",
            website: "http://www.robosmond.com",
            staff: [
                {
                    id:7,
                    firstName: "Ben",
                    surname: "Afleck",
                    mobile: "0488888888",
                    email: "bafleck@robosmond.com",
                    role: "MANAGER"
                },
                {
                    id:8,
                    firstName: "Matt",
                    surname: "Daemon",
                    mobile: "0499999999",
                    email: "mdaemon@robosmond.com",
                    role: "RECEPTION"
                },
                {
                    id:9,
                    firstName: "Rowan",
                    surname: "Rubit",
                    mobile: "0400000000",
                    email: "rrubit@robosmond.com",
                    role: "CEO"
                }
            ],
            properties: [
                {
                    id:4,
                    address:"2/53 Church Road, Carrum 3197",
                    strataNumber: "PS5432",
                    manager:"Rowan Rubbit"
                }
            ]
        }
    ];


});