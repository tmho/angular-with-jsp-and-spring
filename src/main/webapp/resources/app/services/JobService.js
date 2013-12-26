app.service('JobService', function () {
    this.getJobs = function () {
        return jobs;
    }

    this.insertJob = function (property, created, lastModified, contact, company) {
        jobs.push({
            property: property,
            created: created,
            lastModified: lastModified,
            contact: contact,
            company: company
        })
    }

    var jobs = [
        {
            property: {
                address: "4 Casuarina Drive, Frankston 3199",
                strataNumber: "PS1234"
            },
            created: "2013-12-25T23:11:37.358Z",
            lastModified: "2013-12-25T23:11:37.358Z",
            contact: {
                firstName: "Spiderman",
                surname: "Batman",
                mobile: "0433333333",
                email: "spiderman@timosmond.com",
                role: "CEO"
            },
            company: {
                name: "tmho pty ltd",
                phone: "0311111111",
                website: "http://www.timosmond.com"
            }
        }
//        {
//            address: "21 Grassland Ave, Coburg 3058",
//            created: "2013-12-22T23:11:37.358Z",
//            lastModified: "2013-12-22T23:11:37.358Z",
//            status: "JR-000000087",
//            contact: "Tim Lindley",
//            company: "Select Owners Corp"
//        },
//        {
//            address: "1 Gull Court, Patterson Lakes 3197",
//            created: "2013-12-21T23:11:37.358Z",
//            lastModified: "2013-12-21T23:11:37.358Z",
//            status: "QR-000000011",
//            contact: "Maria Del Campo",
//            company: "Bodycorp"
//        },
//        {
//            address: "16 Allison Road, Mount Eliza 3930",
//            created: "2013-12-15T23:11:37.358Z",
//            lastModified: "2013-12-15T23:11:37.358Z",
//            status: "WQ-000000031",
//            contact: "Tim Lindley",
//            company: "Select Owners Corp"
//        },
//        {
//            address: "2/53 Church Road, Carrum 3197",
//            created: "2013-12-05T23:11:37.358Z",
//            lastModified: "2013-12-05T23:11:37.358Z",
//            status: "QR-000000002",
//            contact: "Maria Del Campo",
//            company: "Bodycorp"
//        }
    ];
});