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

val testVenueDetailsJsonResponse = """
    {
        "meta": {
            "code": 200,
            "requestId": "60f41fb86ce8590a364ba047"
        },
        "response": {
            "venue": {
                "id": "3fd66200f964a5209beb1ee3",
                "name": "Peter Luger Steak House",
                "contact": {
                    "phone": "7183877400",
                    "formattedPhone": "(718) 387-7400",
                    "instagram": "peterlugersteakhouse",
                    "facebook": "243860423562",
                    "facebookName": "Peter Luger Steak House Est. 1887"
                },
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
                "canonicalUrl": "https://foursquare.com/v/peter-luger-steak-house/3fd66200f964a5209beb1ee3",
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
                    },
                    {
                        "id": "4bf58dd8d48988d14e941735",
                        "name": "American Restaurant",
                        "pluralName": "American Restaurants",
                        "shortName": "American",
                        "icon": {
                            "prefix": "https://ss3.4sqi.net/img/categories_v2/food/default_",
                            "suffix": ".png"
                        }
                    }
                ],
                "verified": true,
                "stats": {
                    "tipCount": 679
                },
                "url": "http://peterluger.com",
                "price": {
                    "tier": 4,
                    "message": "Very Expensive",
                    "currency": "${'$'}"
                },
                "hasMenu": true,
                "likes": {
                    "count": 1976,
                    "groups": [
                        {
                            "type": "others",
                            "count": 1976,
                            "items": []
                        }
                    ],
                    "summary": "1976 Likes"
                },
                "dislike": false,
                "ok": false,
                "rating": 8.8,
                "ratingColor": "73CF42",
                "ratingSignals": 2687,
                "menu": {
                    "type": "Menu",
                    "label": "Menu",
                    "anchor": "View Menu",
                    "url": "https://foursquare.com/v/peter-luger-steak-house/3fd66200f964a5209beb1ee3/menu",
                    "mobileUrl": "https://foursquare.com/v/3fd66200f964a5209beb1ee3/device_menu"
                },
                "allowMenuUrlEdit": true,
                "beenHere": {
                    "count": 0,
                    "unconfirmedCount": 0,
                    "marked": false,
                    "lastCheckinExpiredAt": 0
                },
                "specials": {
                    "count": 0,
                    "items": []
                },
                "photos": {
                    "count": 3158,
                    "groups": [
                        {
                            "type": "venue",
                            "name": "Venue photos",
                            "count": 3158,
                            "items": [
                                {
                                    "id": "56746c1e498e4c310a4258e6",
                                    "createdAt": 1450470430,
                                    "source": {
                                        "name": "Foursquare Web",
                                        "url": "https://foursquare.com"
                                    },
                                    "prefix": "https://fastly.4sqi.net/img/general/",
                                    "suffix": "/87447937_J9VdinKoIREPNY89gugWIXFuTcA59G97Zpb4LmWeowA.jpg",
                                    "width": 552,
                                    "height": 376,
                                    "visibility": "public"
                                }
                            ]
                        }
                    ]
                },
                "venuePage": {
                    "id": "77462637"
                },
                "reasons": {
                    "count": 1,
                    "items": [
                        {
                            "summary": "Lots of people like this place",
                            "type": "general",
                            "reasonName": "rawLikesReason"
                        }
                    ]
                },
                "description": "Peter Luger Steak House has been serving the finest steaks since 1887. We choose from only the finest USDA PRIME meat available. The selection process is crucial  and therefore is done only by members of the family who visit the wholesale markets on a daily basis.",
                "page": {
                    "user": {
                        "firstName": "Peter Luger Steak House",
                        "countryCode": "US",
                        "type": "venuePage",
                        "venue": {
                            "id": "3fd66200f964a5209beb1ee3"
                        },
                        "tips": {
                            "count": 0
                        },
                        "lists": {
                            "groups": [
                                {
                                    "type": "created",
                                    "count": 2,
                                    "items": []
                                }
                            ]
                        },
                        "bio": ""
                    }
                },
                "hereNow": {
                    "count": 0,
                    "summary": "Nobody here",
                    "groups": []
                },
                "createdAt": 1071014400,
                "tips": {
                    "count": 679,
                    "groups": [
                        {
                            "type": "others",
                            "name": "All tips",
                            "count": 679,
                            "items": [
                                {
                                    "id": "510bc12be4b04c8c993472c6",
                                    "createdAt": 1359724843,
                                    "text": "Girls happened here. Jessa meets Thomas-John's parents at this steakhouse and regales the group with tales of her rehab-attending past.",
                                    "type": "user",
                                    "canonicalUrl": "https://foursquare.com/item/510bc12be4b04c8c993472c6",
                                    "lang": "en",
                                    "likes": {
                                        "count": 45,
                                        "groups": [
                                            {
                                                "type": "others",
                                                "count": 45,
                                                "items": []
                                            }
                                        ],
                                        "summary": "45 likes"
                                    },
                                    "logView": true,
                                    "agreeCount": 45,
                                    "disagreeCount": 0,
                                    "todo": {
                                        "count": 7
                                    },
                                    "user": {
                                        "firstName": "HBO",
                                        "countryCode": "US",
                                        "type": "page"
                                    }
                                }
                            ]
                        }
                    ]
                },
                "shortUrl": "http://4sq.com/4syDel",
                "timeZone": "America/New_York",
                "listed": {
                    "count": 4486,
                    "groups": [
                        {
                            "type": "others",
                            "name": "Lists from other people",
                            "count": 4486,
                            "items": [
                                {
                                    "id": "54c9597c498e50bd18a9d63a",
                                    "name": "The Tastes that Make the City: New York Edition",
                                    "description": "From the pastrami sandwich at Katz's to Balthazar's pomme frites, there are some dishes that are classic NYC. Foursquare's data scientists identified the top 50, and we challenge you to try them all.",
                                    "type": "others",
                                    "user": {
                                        "firstName": "The Tastes that Make the City",
                                        "countryCode": "US"
                                    },
                                    "editable": false,
                                    "public": true,
                                    "collaborative": false,
                                    "url": "/citytastes/list/the-tastes-that-make-the-city-new-york-edition",
                                    "canonicalUrl": "https://foursquare.com/citytastes/list/the-tastes-that-make-the-city-new-york-edition",
                                    "createdAt": 1422481788,
                                    "updatedAt": 1435256661,
                                    "photo": {
                                        "id": "5568808c498eda92ec60e893",
                                        "createdAt": 1432912012,
                                        "prefix": "https://fastly.4sqi.net/img/general/",
                                        "suffix": "/107525669_evsnhV04T8wpsz1MLCMupb3OwANaIIhLLeqKGkGLZU4.jpg",
                                        "width": 720,
                                        "height": 960,
                                        "visibility": "public"
                                    },
                                    "readMoreUrl": "https://foursquare.com/top-places/new-york-city/tastes-that-make-the-city",
                                    "guideType": "bestOf",
                                    "guide": true,
                                    "followers": {
                                        "count": 2758
                                    },
                                    "listItems": {
                                        "count": 50,
                                        "items": [
                                            {
                                                "id": "t54c95979498e01d155e613e8",
                                                "createdAt": 1422481794,
                                                "photo": {
                                                    "id": "5568859c498eda92ec624f51",
                                                    "createdAt": 1432913308,
                                                    "prefix": "https://fastly.4sqi.net/img/general/",
                                                    "suffix": "/107525669_iySQSaV9kEHrehOkYEFQsE22Qmw71o0YaTMV2cajv3g.jpg",
                                                    "width": 960,
                                                    "height": 960,
                                                    "visibility": "public"
                                                }
                                            }
                                        ]
                                    }
                                },
                                {
                                    "id": "4f3e715ce4b0abb6d69b61de",
                                    "name": "2013 NYC Michelin Starred Restaurants",
                                    "description": "In the latest edition of the highly anticipated MICHELIN Guide New York City 2013, a record 66 restaurants have been awarded Michelin stars.",
                                    "type": "others",
                                    "user": {
                                        "firstName": "Michelin Travel & Lifestyle",
                                        "countryCode": "IT",
                                        "type": "page"
                                    },
                                    "editable": false,
                                    "public": true,
                                    "collaborative": false,
                                    "url": "/michelinguides/list/2013-nyc-michelin-starred-restaurants",
                                    "canonicalUrl": "https://foursquare.com/michelinguides/list/2013-nyc-michelin-starred-restaurants",
                                    "createdAt": 1329492316,
                                    "updatedAt": 1384107446,
                                    "logView": true,
                                    "followers": {
                                        "count": 3752
                                    },
                                    "listItems": {
                                        "count": 66,
                                        "items": [
                                            {
                                                "id": "v3fd66200f964a5209beb1ee3",
                                                "createdAt": 1329493205
                                            }
                                        ]
                                    }
                                },
                                {
                                    "id": "4e2df6f13151250387b53f5c",
                                    "name": "The 38 Essential New York Restaurants, Winter 2017",
                                    "description": "This highly elite group covers the entire city, spans myriad cuisines, and collectively satisfies all of your restaurant needs, save for those occasions when you absolutely must spend half a paycheck.",
                                    "type": "others",
                                    "user": {
                                        "firstName": "Eater",
                                        "countryCode": "US",
                                        "type": "page"
                                    },
                                    "editable": false,
                                    "public": true,
                                    "collaborative": false,
                                    "url": "/p/eater/3343327/list/the-38-essential-new-york-restaurants-winter-2017",
                                    "canonicalUrl": "https://foursquare.com/p/eater/3343327/list/the-38-essential-new-york-restaurants-winter-2017",
                                    "createdAt": 1311635185,
                                    "updatedAt": 1484851385,
                                    "photo": {
                                        "id": "55490a63498e64abc166eb13",
                                        "createdAt": 1430850147,
                                        "prefix": "https://fastly.4sqi.net/img/general/",
                                        "suffix": "/3343327_KqrI41-ij_diYuWv4rYIR1y6P_0S6tFToA0HanEM6h8.jpg",
                                        "width": 2048,
                                        "height": 1363,
                                        "visibility": "public"
                                    },
                                    "logView": true,
                                    "readMoreUrl": "http://ny.eater.com/maps/best-new-york-restaurants-38",
                                    "guideType": "bestOf",
                                    "guide": true,
                                    "followers": {
                                        "count": 6866
                                    },
                                    "listItems": {
                                        "count": 38,
                                        "items": [
                                            {
                                                "id": "t570568c4498ecadbcaf0d132",
                                                "createdAt": 1459982833,
                                                "photo": {
                                                    "id": "57928ae3498e325d9be4f1d7",
                                                    "createdAt": 1469221603,
                                                    "prefix": "https://fastly.4sqi.net/img/general/",
                                                    "suffix": "/3343327__Y_9Ux3Bai4WvgRxZWNbcqr5Q3yfE5UCTabwNZvt_iI.png",
                                                    "width": 481,
                                                    "height": 358,
                                                    "visibility": "public"
                                                }
                                            }
                                        ]
                                    }
                                },
                                {
                                    "id": "560d746d498eb89dd0264ed8",
                                    "name": "NYC's 2016 Michelin-Starred Restaurants",
                                    "description": "The results are in for this year's Michelin stars. Newer spots gained recognition along with the classic NYC establishments that continue to shine. Here is the full list of top-notch restaurants.",
                                    "type": "others",
                                    "user": {
                                        "firstName": "Foursquare City Guide",
                                        "countryCode": "US",
                                        "type": "page"
                                    },
                                    "editable": false,
                                    "public": true,
                                    "collaborative": false,
                                    "url": "/foursquare/list/nycs-2016-michelinstarred-restaurants",
                                    "canonicalUrl": "https://foursquare.com/foursquare/list/nycs-2016-michelinstarred-restaurants",
                                    "createdAt": 1443722349,
                                    "updatedAt": 1509051620,
                                    "photo": {
                                        "id": "54f949c1498e91d4c02f5f39",
                                        "createdAt": 1425623489,
                                        "prefix": "https://fastly.4sqi.net/img/general/",
                                        "suffix": "/13152975_IjDJlZf1ckcQepnaBYQbCJ4qc2utlMGcYDbvHOkEVLU.jpg",
                                        "width": 1477,
                                        "height": 1440,
                                        "visibility": "public"
                                    },
                                    "logView": true,
                                    "guideType": "bestOf",
                                    "guide": true,
                                    "followers": {
                                        "count": 1352
                                    },
                                    "listItems": {
                                        "count": 74,
                                        "items": [
                                            {
                                                "id": "t55b3ef52498e9b90bdc41bbc",
                                                "createdAt": 1443728765,
                                                "photo": {
                                                    "id": "55e288e2498eeeede35bb9f5",
                                                    "createdAt": 1440909538,
                                                    "prefix": "https://fastly.4sqi.net/img/general/",
                                                    "suffix": "/120058_Jz-In4t5E-eS-cCRx9IOs1NNU1ieTmcbUviB0UcML4g.jpg",
                                                    "width": 1920,
                                                    "height": 1440,
                                                    "visibility": "public"
                                                }
                                            }
                                        ]
                                    }
                                }
                            ]
                        }
                    ]
                },
                "hours": {
                    "status": "Closed until 12:45 PM",
                    "richStatus": {
                        "entities": [],
                        "text": "Closed until 12:45 PM"
                    },
                    "isOpen": false,
                    "isLocalHoliday": false,
                    "dayData": [],
                    "timeframes": [
                        {
                            "days": "Mon–Thu",
                            "open": [
                                {
                                    "renderedTime": "11:45 AM–9:45 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Fri–Sat",
                            "open": [
                                {
                                    "renderedTime": "11:45 AM–10:45 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Sun",
                            "includesToday": true,
                            "open": [
                                {
                                    "renderedTime": "12:45 PM–9:45 PM"
                                }
                            ],
                            "segments": []
                        }
                    ]
                },
                "popular": {
                    "isOpen": false,
                    "isLocalHoliday": false,
                    "timeframes": [
                        {
                            "days": "Today",
                            "includesToday": true,
                            "open": [
                                {
                                    "renderedTime": "Noon–10:00 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Mon",
                            "open": [
                                {
                                    "renderedTime": "Noon–3:00 PM"
                                },
                                {
                                    "renderedTime": "5:00 PM–10:00 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Tue–Wed",
                            "open": [
                                {
                                    "renderedTime": "Noon–2:00 PM"
                                },
                                {
                                    "renderedTime": "5:00 PM–10:00 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Thu",
                            "open": [
                                {
                                    "renderedTime": "Noon–3:00 PM"
                                },
                                {
                                    "renderedTime": "5:00 PM–10:00 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Fri–Sat",
                            "open": [
                                {
                                    "renderedTime": "Noon–11:00 PM"
                                }
                            ],
                            "segments": []
                        }
                    ]
                },
                "seasonalHours": [],
                "defaultHours": {
                    "status": "Closed until 12:45 PM",
                    "richStatus": {
                        "entities": [],
                        "text": "Closed until 12:45 PM"
                    },
                    "isOpen": false,
                    "isLocalHoliday": false,
                    "dayData": [],
                    "timeframes": [
                        {
                            "days": "Mon–Thu",
                            "open": [
                                {
                                    "renderedTime": "11:45 AM–9:45 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Fri–Sat",
                            "open": [
                                {
                                    "renderedTime": "11:45 AM–10:45 PM"
                                }
                            ],
                            "segments": []
                        },
                        {
                            "days": "Sun",
                            "includesToday": true,
                            "open": [
                                {
                                    "renderedTime": "12:45 PM–9:45 PM"
                                }
                            ],
                            "segments": []
                        }
                    ]
                },
                "pageUpdates": {
                    "count": 0,
                    "items": []
                },
                "inbox": {
                    "count": 0,
                    "items": []
                },
                "attributes": {
                    "groups": [
                        {
                            "type": "price",
                            "name": "Price",
                            "summary": "${'$'}${'$'}${'$'}${'$'}",
                            "count": 1,
                            "items": [
                                {
                                    "displayName": "Price",
                                    "displayValue": "${'$'}${'$'}${'$'}${'$'}",
                                    "priceTier": 4
                                }
                            ]
                        },
                        {
                            "type": "reservations",
                            "name": "Reservations",
                            "summary": "Reservations",
                            "count": 3,
                            "items": [
                                {
                                    "displayName": "Reservations",
                                    "displayValue": "Yes"
                                }
                            ]
                        },
                        {
                            "type": "payments",
                            "name": "Credit Cards",
                            "summary": "No Credit Cards",
                            "count": 7,
                            "items": [
                                {
                                    "displayName": "Credit Cards",
                                    "displayValue": "No"
                                }
                            ]
                        },
                        {
                            "type": "outdoorSeating",
                            "name": "Outdoor Seating",
                            "count": 1,
                            "items": [
                                {
                                    "displayName": "Outdoor Seating",
                                    "displayValue": "No"
                                }
                            ]
                        },
                        {
                            "type": "privateRoom",
                            "name": "Private Room",
                            "summary": "Private Room",
                            "count": 1,
                            "items": [
                                {
                                    "displayName": "Private Room",
                                    "displayValue": "Yes"
                                }
                            ]
                        },
                        {
                            "type": "serves",
                            "name": "Menus",
                            "summary": "Dessert, Brunch & more",
                            "count": 8,
                            "items": [
                                {
                                    "displayName": "Brunch",
                                    "displayValue": "Brunch"
                                },
                                {
                                    "displayName": "Lunch",
                                    "displayValue": "Lunch"
                                },
                                {
                                    "displayName": "Dinner",
                                    "displayValue": "Dinner"
                                },
                                {
                                    "displayName": "Dessert",
                                    "displayValue": "Dessert"
                                }
                            ]
                        },
                        {
                            "type": "drinks",
                            "name": "Drinks",
                            "summary": "Beer, Wine, Full Bar & Cocktails",
                            "count": 5,
                            "items": [
                                {
                                    "displayName": "Beer",
                                    "displayValue": "Beer"
                                },
                                {
                                    "displayName": "Wine",
                                    "displayValue": "Wine"
                                },
                                {
                                    "displayName": "Full Bar",
                                    "displayValue": "Full Bar"
                                },
                                {
                                    "displayName": "Cocktails",
                                    "displayValue": "Cocktails"
                                }
                            ]
                        },
                        {
                            "type": "restroom",
                            "name": "Restroom",
                            "summary": "Restroom",
                            "count": 1,
                            "items": [
                                {
                                    "displayName": "Restroom",
                                    "displayValue": "Yes"
                                }
                            ]
                        }
                    ]
                },
                "bestPhoto": {
                    "id": "56746c1e498e4c310a4258e6",
                    "createdAt": 1450470430,
                    "source": {
                        "name": "Foursquare Web",
                        "url": "https://foursquare.com"
                    },
                    "prefix": "https://fastly.4sqi.net/img/general/",
                    "suffix": "/87447937_J9VdinKoIREPNY89gugWIXFuTcA59G97Zpb4LmWeowA.jpg",
                    "width": 552,
                    "height": 376,
                    "visibility": "public"
                },
                "colors": {
                    "highlightColor": {
                        "photoId": "56746c1e498e4c310a4258e6",
                        "value": -2039608
                    },
                    "highlightTextColor": {
                        "photoId": "56746c1e498e4c310a4258e6",
                        "value": -16777216
                    },
                    "algoVersion": 3
                }
            }
        }
    }
""".trimIndent()