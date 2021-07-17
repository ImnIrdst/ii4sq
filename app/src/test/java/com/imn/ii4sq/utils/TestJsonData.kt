package com.imn.ii4sq.utils

val testSearchJsonResponse = """
    {
        "meta": {
            "code": 200,
            "requestId": "60efd41b2222750a7254e924"
        },
        "response": {
            "venues": [
                {
                    "id": "3fd66200f964a5209beb1ee3",
                    "name": "Peter Luger Steak House",
                    "location": {
                        "address": "178 Broadway",
                        "crossStreet": "at Driggs Ave",
                        "lat": 40.70995790682886,
                        "lng": -73.96229110893742,
                        "labeledLatLngs": [
                            {
                                "label": "display",
                                "lat": 40.70995790682886,
                                "lng": -73.96229110893742
                            },
                            {
                                "label": "entrance",
                                "lat": 40.709915,
                                "lng": -73.962633
                            }
                        ],
                        "distance": 10,
                        "postalCode": "11211",
                        "cc": "US",
                        "neighborhood": "Williamsburg",
                        "city": "Brooklyn",
                        "state": "NY",
                        "country": "United States",
                        "formattedAddress": [
                            "178 Broadway (at Driggs Ave)",
                            "Brooklyn, NY 11211",
                            "United States"
                        ]
                    },
                    "categories": [
                        {
                            "id": "4bf58dd8d48988d1cc941735",
                            "name": "Steakhouse",
                            "pluralName": "Steakhouses",
                            "shortName": "Steakhouse",
                            "icon": {
                                "prefix": "https://ss3.4sqi.net/img/categories_v2/food/steakhouse_",
                                "suffix": ".png"
                            },
                            "primary": true
                        }
                    ],
                    "venuePage": {
                        "id": "77462637"
                    },
                    "referralId": "v-1626330139",
                    "hasPerk": false
                },
                {
                    "id": "4b410414f964a5206dbf25e3",
                    "name": "Brooklyn Industries",
                    "location": {
                        "address": "184 Broadway (at Driggs)",
                        "crossStreet": "btwn Driggs Ave & Roebling St",
                        "lat": 40.709751,
                        "lng": -73.962264,
                        "labeledLatLngs": [
                            {
                                "label": "display",
                                "lat": 40.709751,
                                "lng": -73.962264
                            },
                            {
                                "label": "entrance",
                                "lat": 40.70977,
                                "lng": -73.962189
                            }
                        ],
                        "distance": 17,
                        "postalCode": "11211",
                        "cc": "US",
                        "city": "Brooklyn",
                        "state": "NY",
                        "country": "United States",
                        "formattedAddress": [
                            "184 Broadway (at Driggs) (btwn Driggs Ave & Roebling St)",
                            "Brooklyn, NY 11211",
                            "United States"
                        ]
                    },
                    "categories": [
                        {
                            "id": "4bf58dd8d48988d103951735",
                            "name": "Clothing Store",
                            "pluralName": "Clothing Stores",
                            "shortName": "Apparel",
                            "icon": {
                                "prefix": "https://ss3.4sqi.net/img/categories_v2/shops/apparel_",
                                "suffix": ".png"
                            },
                            "primary": true
                        }
                    ],
                    "referralId": "v-1626330139",
                    "hasPerk": false
                },
                {
                    "id": "5a773521bd897e5943e4655e",
                    "name": "M & N Deli Organic",
                    "location": {
                        "address": "186 Broadway",
                        "crossStreet": "Driggs Ave",
                        "lat": 40.709878,
                        "lng": -73.962176,
                        "labeledLatLngs": [
                            {
                                "label": "display",
                                "lat": 40.709878,
                                "lng": -73.962176
                            }
                        ],
                        "distance": 3,
                        "postalCode": "11211",
                        "cc": "US",
                        "city": "New York",
                        "state": "NY",
                        "country": "United States",
                        "formattedAddress": [
                            "186 Broadway (Driggs Ave)",
                            "New York, NY 11211",
                            "United States"
                        ]
                    },
                    "categories": [
                        {
                            "id": "4bf58dd8d48988d146941735",
                            "name": "Deli / Bodega",
                            "pluralName": "Delis / Bodegas",
                            "shortName": "Deli / Bodega",
                            "icon": {
                                "prefix": "https://ss3.4sqi.net/img/categories_v2/food/deli_",
                                "suffix": ".png"
                            },
                            "primary": true
                        }
                    ],
                    "referralId": "v-1626330139",
                    "hasPerk": false
                },
                {
                    "id": "5aec6610031320002c8ffb75",
                    "name": "The Yard: South Williamsburg",
                    "location": {
                        "address": "195 Broadway",
                        "crossStreet": "at Driggs Ave",
                        "lat": 40.710035,
                        "lng": -73.96189,
                        "labeledLatLngs": [
                            {
                                "label": "display",
                                "lat": 40.710035,
                                "lng": -73.96189
                            },
                            {
                                "label": "entrance",
                                "lat": 40.709888,
                                "lng": -73.961856
                            }
                        ],
                        "distance": 30,
                        "postalCode": "11211",
                        "cc": "US",
                        "city": "Brooklyn",
                        "state": "NY",
                        "country": "United States",
                        "formattedAddress": [
                            "195 Broadway (at Driggs Ave)",
                            "Brooklyn, NY 11211",
                            "United States"
                        ]
                    },
                    "categories": [
                        {
                            "id": "4bf58dd8d48988d174941735",
                            "name": "Coworking Space",
                            "pluralName": "Coworking Spaces",
                            "shortName": "Coworking Space",
                            "icon": {
                                "prefix": "https://ss3.4sqi.net/img/categories_v2/building/office_coworkingspace_",
                                "suffix": ".png"
                            },
                            "primary": true
                        }
                    ],
                    "referralId": "v-1626330139",
                    "hasPerk": false
                },
                {
                    "id": "47ba5995f964a520cc4d1fe3",
                    "name": "DOC Wine Shop",
                    "location": {
                        "address": "147 Broadway",
                        "crossStreet": "Bedford Ave",
                        "lat": 40.71034705916352,
                        "lng": -73.96336413616211,
                        "labeledLatLngs": [
                            {
                                "label": "display",
                                "lat": 40.71034705916352,
                                "lng": -73.96336413616211
                            },
                            {
                                "label": "entrance",
                                "lat": 40.710551,
                                "lng": -73.96313
                            }
                        ],
                        "distance": 110,
                        "postalCode": "11211",
                        "cc": "US",
                        "city": "Brooklyn",
                        "state": "NY",
                        "country": "United States",
                        "formattedAddress": [
                            "147 Broadway (Bedford Ave)",
                            "Brooklyn, NY 11211",
                            "United States"
                        ]
                    },
                    "categories": [
                        {
                            "id": "4bf58dd8d48988d119951735",
                            "name": "Wine Shop",
                            "pluralName": "Wine Shops",
                            "shortName": "Wine Shop",
                            "icon": {
                                "prefix": "https://ss3.4sqi.net/img/categories_v2/shops/food_wineshop_",
                                "suffix": ".png"
                            },
                            "primary": true
                        }
                    ],
                    "delivery": {
                        "id": "2466058",
                        "url": "https://www.seamless.com/menu/doc-wine-shop-147-broadway-brooklyn/2466058?affiliate=1131&utm_source=foursquare-affiliate-network&utm_medium=affiliate&utm_campaign=1131&utm_content=2466058",
                        "provider": {
                            "name": "seamless",
                            "icon": {
                                "prefix": "https://fastly.4sqi.net/img/general/cap/",
                                "sizes": [
                                    40,
                                    50
                                ],
                                "name": "/delivery_provider_seamless_20180129.png"
                            }
                        }
                    },
                    "venuePage": {
                        "id": "81278040"
                    },
                    "referralId": "v-1626330139",
                    "hasPerk": false
                }
            ],
            "confident": false
        }
    }
""".trimIndent()

val testSearchJsonResponseAfterPan = """
    {
        "meta": {
            "code": 200,
            "requestId": "60efd41b2222750a7254e924"
        },
        "response": {
            "venues": [
                {
                    "id": "14",
                    "name": "Test Location After Pan",
                    "location": {
                        "address": "Test Location After Pan address",
                        "crossStreet": "Test Location After Pan address cross street",
                        "lat": 10.70995790682886,
                        "lng": -33.96229110893742,
                        "labeledLatLngs": [
                            {
                                "label": "display",
                                "lat": 40.70995790682886,
                                "lng": -73.96229110893742
                            },
                            {
                                "label": "entrance",
                                "lat": 40.709915,
                                "lng": -73.962633
                            }
                        ],
                        "distance": 10,
                        "postalCode": "11211",
                        "cc": "US",
                        "neighborhood": "Williamsburg",
                        "city": "Brooklyn",
                        "state": "NY",
                        "country": "United States",
                        "formattedAddress": [
                            "Test Location After Pan street",
                            "Brooklyn, NY 11211",
                            "United States"
                        ]
                    },
                    "categories": [
                        {
                            "id": "4bf58dd8d48988d1cc941735",
                            "name": "Steakhouse",
                            "pluralName": "Steakhouses",
                            "shortName": "Steakhouse",
                            "icon": {
                                "prefix": "https://ss3.4sqi.net/img/categories_v2/food/steakhouse_",
                                "suffix": ".png"
                            },
                            "primary": true
                        }
                    ],
                    "venuePage": {
                        "id": "77462637"
                    },
                    "referralId": "v-1626330139",
                    "hasPerk": false
                }
            ],
            "confident": false
        }
    }
""".trimIndent()