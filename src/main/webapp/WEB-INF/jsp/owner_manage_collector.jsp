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




<div class="maincontent-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <table class="shop_table" id="tblCustomers">
                    <thead>
                    <tr>
                        <th class="product-total">User Id</th>
                        <th class="product-total">User Name</th>
                        <th class="product-total">First Name</th>
                        <th class="product-total">Last Name</th>
                        <th class="product-total">Creation Date</th>
                        <th class="product-total" style="width: 35%;">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${hash}" var="hash">
                        <tr>
                            <td><c:out value="${hash.value.collector_id}" /></td>
                            <td><c:out value="${hash.key.username}" /></td>
                            <td><c:out value="${hash.key.firstname}" /></td>
                            <td><c:out value="${hash.key.lastname}" /></td>
                            <td><c:out value="${hash.value.creation_date}" /></td>
                            <td>
                                <div class="row">
                                    <div class="col-md-6">
                                        <a href="ownerEditEmployee/${hash.key.username}" type="button" style="width:100px;height:45px;"class="btn btn-primary" >Edit</a>
                                    </div>
                                    <div class="col-md-6">
                                        <form action="ownerDeleteEmployee/${hash.key.username}" method="post">
                                            <input type="hidden" id="artId" name="artId" value="">
                                            <button type="submit" class="btn btn-danger">Delete</button>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input type="button" id="btnExport" value="Export" onclick="Export()" />
            </div>
        </div>
    </div>
</div> <!-- End main content area -->






<%--<div class="footer-bottom-area">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-8">--%>
<%--                <!-- <div class="copyright"> -->--%>
<%--                <!-- <p>&copy; 2015 uCommerce. All Rights Reserved. <a href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a></p> -->--%>
<%--                <!-- </div> -->--%>
<%--            </div>--%>

<%--            <!-- <div class="col-md-4"> -->--%>
<%--            <!-- <div class="footer-card-icon"> -->--%>
<%--            <!-- <i class="fa fa-cc-discover"></i> -->--%>
<%--            <!-- <i class="fa fa-cc-mastercard"></i> -->--%>
<%--            <!-- <i class="fa fa-cc-paypal"></i> -->--%>
<%--            <!-- <i class="fa fa-cc-visa"></i> -->--%>
<%--            <!-- </div> -->--%>
<%--            <!-- </div> -->--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div> <!-- End footer bottom area -->--%>

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

<!-- Slider -->
<script type="text/javascript" src="js/bxslider.min.js"></script>
<script type="text/javascript" src="js/script.slider.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
<script type="text/javascript">
    function Export() {
        html2canvas(document.getElementById('tblCustomers'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 500
                    }]
                };
                pdfMake.createPdf(docDefinition).download("Table.pdf");
            }
        });
    }
</script>
</body>

</html>