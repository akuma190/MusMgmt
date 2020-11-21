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
    <link rel="stylesheet" href="style.css">
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
                        <li><a href="owner_index.html">Home</a></li>
                        <li><a href="owner_artwork_list.html">Artwork List</a></li>
                        <li><a href="owner_painting_approve.html">New Entries</a></li>
                        <li><a href="owner_create_event.html">Create Event</a></li>
                        <li><a href="owner_check_report.html">Check Report</a></li>
                        <li><a href="owner_manage_paintings.html">Manage Paintings</a></li>
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

                            <div class="woocommerce-info">Enter the event details
                            </div>

                            <form id="coupon-collapse-wrap" method="post" class="checkout_coupon collapse">

                                <p class="form-row form-row-first">
                                    <input type="text" value="" id="coupon_code" placeholder="Coupon code"
                                        class="input-text" name="coupon_code">
                                </p>

                                <p class="form-row form-row-last">
                                    <input type="submit" value="Apply Coupon" name="apply_coupon" class="button">
                                </p>

                                <div class="clear"></div>
                            </form>

                            <form enctype="multipart/form-data" action="#" class="checkout" method="post"
                                name="checkout">

                                <div id="customer_details" class="col2-set">
                                    <div class="col-6">
                                        <div class="woocommerce-billing-fields">
                                            <p id="billing_country_field"
                                                class="form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated">
                                                <label class="" for="billing_country">Event Type 
                                                </label>
                                                <select class="country_to_state country_select" id="billing_country"
                                                    name="billing_country">
                                                    <option value="">Select the event type…</option>
                                                    <option value="AX">Single Artist</option>
                                                    <option value="AF">Multiple Artist</option>
                                                </select>
                                            </p>

                                            <p id="billing_first_name_field"
                                                class="form-row form-row-first validate-required">
                                                <label class="" for="billing_first_name">Event Name 
                                                </label>
                                                <input type="text" value="" placeholder="" id="billing_first_name"
                                                    name="billing_first_name" class="input-text ">
                                            </p>

                                            <p id="billing_last_name_field"
                                                class="form-row form-row-last validate-required">
                                                <label class="" for="billing_last_name">Artist Name 
                                                </label>
                                                <input type="text" value="" placeholder="" id="billing_last_name"
                                                    name="billing_last_name" class="input-text ">
                                            </p>
                                            <div class="clear"></div>

                                            <p id="billing_company_field" class="form-row form-row-wide">
                                                <label class="" for="billing_company">Start Date</label>
                                                <input type="date" value="" placeholder="" id="billing_company"
                                                    name="billing_company" style="width: 1170px;">
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
</body>

</html>