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
    <title>Museum Management</title>

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
                <div class="shopping-item">
                    <a href="/">Hi ${session.username} !! - <span class="cart-amunt">Logout</span> </a>
                </div>
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
                        <li><a href="ownerCheckReport">Report</a></li>
                        <li><a href="ownerManagePaintings">Manage Paintings</a></li>
                        <li><a href="ownerManageEvents">Manage Events</a></li>
                        <li><a href="ownerManageArtwork">Manage Artwork</a></li>
                        <li><a href="ownerManageArtists">Manage Artists</a></li>
                        <li><a href="ownerManageCollectors">Manage Collectors</a></li>
                        <li><a href="ownerManageCustomers">Manage Customers</a></li>
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
                        <div class="row">
                            <div class="col-sm-2">

                            </div>
                            <div class="col-sm-4">
                                <div class="product-images">
                                    <div class="product-main-img">
                                        <img src="img/product-2.jpg" alt="">
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="product-inner">
                                    <h2 class="product-name">Painting Name</h2>

                                    <form action="" class="cart">
                                        <div class="quantity">
                                            <p id="billing_country_field"
                                                class="form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated">
                                                <label class="" for="billing_country">Sales Person Name
                                                </label>
                                            </p>
                                        </div>
                                    </form>

                                    <div role="tabpanel">
                                        <ul class="product-tab" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home"
                                                    role="tab" data-toggle="tab">Painting Description</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <table class="shop_table">
                                                    <tfoot>

                                                        <tr class="cart-subtotal">
                                                            <th>Id</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Painting Name</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Artist or Collector Name</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Creation Date</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Painting Type</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Painting Style</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>medium</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Type</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Quoted Price</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Action</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Length</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Width</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>
                                                        <tr class="cart-subtotal">
                                                            <th>Height</th>
                                                            <td><span class="amount">£15.00</span>
                                                            </td>
                                                        </tr>

                                                    </tfoot>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


<%--    <div class="footer-bottom-area">--%>
<%--        <div class="container">--%>
<%--            <div class="row">--%>
<%--                <div class="col-md-8">--%>
<%--                    <!-- <div class="copyright"> -->--%>
<%--                    <!-- <p>&copy; 2015 uCommerce. All Rights Reserved. <a href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a></p> -->--%>
<%--                    <!-- </div> -->--%>
<%--                </div>--%>

<%--                <!-- <div class="col-md-4"> -->--%>
<%--                <!-- <div class="footer-card-icon"> -->--%>
<%--                <!-- <i class="fa fa-cc-discover"></i> -->--%>
<%--                <!-- <i class="fa fa-cc-mastercard"></i> -->--%>
<%--                <!-- <i class="fa fa-cc-paypal"></i> -->--%>
<%--                <!-- <i class="fa fa-cc-visa"></i> -->--%>
<%--                <!-- </div> -->--%>
<%--                <!-- </div> -->--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div> <!-- End footer bottom area -->--%>

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