<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
ustora by freshdesignweb.com
Twitter: https://twitter.com/freshdesignweb
URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Checkout Page - Ustora Demo</title>

    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet'
          type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>


<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="logo">
                    <h1><a href="./"><img src="img/logo.png"></a></h1>
                </div>
            </div>

            <div class="col-sm-6">
                <!-- <div class="shopping-item">
                    <a href="cart.html">Cart - <span class="cart-amunt">$100</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                </div> -->
            </div>
        </div>
    </div>
</div> <!-- End site branding area -->

<div class="mainmenu-area" style="background:black">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="ownerIndex">Home</a></li>
                    <li><a href="ownerArtworkList">Artwork List</a></li>
                    <li><a href="ownerPaintingsApprove">New Entries</a></li>
                    <li><a href="ownerCreateEvent">Create Event</a></li>
                    <li><a href="ownerCheckReport">Check Report</a></li>
                    <li><a href="ownerManagePaintings">Manage Paintings</a></li>
                </ul>
            </div>
        </div>
    </div>
</div> <!-- End mainmenu area -->




<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">


            <div class="col-md-12">
                <div class="product-content-right">
                    <div class="woocommerce">

                        <div class="woocommerce-info">Below Are Your Event Details
                        </div>



                        <form enctype="multipart/form-data" action="ownerAddPaintings" class="checkout" method="post"
                              name="checkout">

                            <div id="customer_details" class="col2-set">
                                <div class="col-6">
                                    <div class="woocommerce-billing-fields">
                                        <p id="billing_country_field"
                                           class="form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated">
                                            <label class="" for="idEventtype">Event Type
                                            </label>
                                            <input type="text" value="${eve.eventtype}" placeholder="" id=""
                                                   name="" class="input-text " disabled>
                                            <input type="hidden" value="${eve.eventtype}" placeholder="" id="idEventtype"
                                                   name="eventtype" class="input-text " >
                                        </p>

                                        <p id="billing_first_name_field"
                                           class="form-row form-row-first validate-required">
                                            <label class="" for="idEventname">Event Name
                                            </label>
                                            <input type="text" value="${eve.eventname}" placeholder="" id=""
                                                   name="" class="input-text " disabled>
                                            <input type="hidden" value="${eve.eventname}" placeholder="" id="idEventname"
                                                   name="eventname" class="input-text " >
                                        </p>

                                        <p id="billing_artist_field"
                                           class="form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated" >
                                            <label class="" for="idArtistid">Event Type
                                            </label>
                                            <input type="text" value="${eve.artistid}" placeholder="" id=""
                                                   name="" class="input-text " disabled>
                                            <input type="hidden" value="${eve.artistid}" placeholder="" id="idArtistid"
                                                   name="artistid" class="input-text " >
                                        </p>


                                        <div class="clear"></div>

                                        <p id="billing_company_field" class="form-row form-row-wide">
                                            <label class="" for="idCreationdate">Start Date</label>
                                            <input type="text" value="${eve.creationdate}" placeholder="" id=""
                                                   name="" class="input-text " disabled>
                                            <input type="hidden" value="${eve.creationdate}" placeholder="" id="idCreationdate"
                                                   name="creationdate" class="input-text " >
                                        </p>


                                        <div class="form-row place-order">

                                            <input type="submit" data-value="Add Paintings" value="Add Paintings" id="place_order" name="woocommerce_checkout_place_order" class="button alt">

                                        </div>

                                    </div>
                                </div>

                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="footer-bottom-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <!-- <div class="copyright"> -->
                <!-- <p>&copy; 2015 uCommerce. All Rights Reserved. <a href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a></p> -->
                <!-- </div> -->
            </div>

            <!-- <div class="col-md-4"> -->
            <!-- <div class="footer-card-icon"> -->
            <!-- <i class="fa fa-cc-discover"></i> -->
            <!-- <i class="fa fa-cc-mastercard"></i> -->
            <!-- <i class="fa fa-cc-paypal"></i> -->
            <!-- <i class="fa fa-cc-visa"></i> -->
            <!-- </div> -->
            <!-- </div> -->
        </div>
    </div>
</div> <!-- End footer bottom area -->

<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="js/main.js"></script>
<script>
    function changetextbox()
    {
        if (document.getElementById("idEventtype").value === "single") {
            document.getElementById("myDiv").style.display="block";
            // alert("hello");
        }
        else {
            document.getElementById("myDiv").style.display="none";
        }
    }
</script>
</body>

</html>