package com.claim.constant;

public class InvoiceTemplate {
	
	public static String buildTemplate(){

		return "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"    <head>\r\n" + 
				"\r\n" + 
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </head>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <body class=\"fixed-left\">\r\n" + 
				"\r\n" + 
				"        <!-- Begin page -->\r\n" + 
				"        <div id=\"wrapper\">\r\n" + 
				"\r\n" + 
				"            <!-- Start right Content here -->\r\n" + 
				"\r\n" + 
				"            <div class=\"content-page\">\r\n" + 
				"                <!-- Start content -->\r\n" + 
				"                <div class=\"content\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"                    <div class=\"page-content-wrapper \">\r\n" + 
				"\r\n" + 
				"                        <div class=\"container\">\r\n" + 
				"                            <div class=\"row\">\r\n" + 
				"                                <div class=\"col-md-12\">\r\n" + 
				"                                    <div class=\"panel panel-default\">\r\n" + 
				"                                        <!-- <div class=\"panel-heading\">\r\n" + 
				"                                            <h4>Invoice</h4>\r\n" + 
				"                                        </div> -->\r\n" + 
				"                                        <div class=\"panel-body\">\r\n" + 
				"\r\n" + 
				"                                            <div class=\"row\">\r\n" + 
				"                                                <div class=\"col-xs-12\">\r\n" + 
				"                                                    <div class=\"invoice-title\">\r\n" + 
				"                                                        <h4 class=\"pull-right\">Invoice # 12345</h4>\r\n" + 
				"                                                        <h3 class=\"m-t-0\">Missouri State Training Center</h3>\r\n" + 
				"                                                    </div>\r\n" + 
				"                                                    <hr>\r\n" + 
				"                                                    <div class=\"row\">\r\n" + 
				"                                                        <div class=\"col-xs-6\">\r\n" + 
				"                                                            <address>\r\n" + 
				"                                                                <strong>Billed To:</strong><br>\r\n" + 
				"                                                                ${agency.agencyName}<br>\r\n" + 
				"                                                                ${agency.streetAddress}<br>\r\n" + 
				"                                                                ${agency.poBox}<br>\r\n" + 
				"                                                                ${agency.city}, ${agency.state} ${agency.zip}\r\n" + 
				"                                                            </address>\r\n" + 
				"                                                        </div>\r\n" + 
				"                                                        <div class=\"col-xs-6 text-right\">\r\n" + 
				"                                                            <address>\r\n" + 
				"                                                                <strong>Invoice Date:</strong><br>\r\n" + 
				"                                                                ${df.date}<br><br>\r\n" + 
				"                                                            </address>\r\n" + 
				"                                                        </div>\r\n" + 
				"                                                    </div>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"\r\n" + 
				"                                            <div class=\"row\">\r\n" + 
				"                                                <div class=\"col-md-12\">\r\n" + 
				"                                                    <div class=\"panel panel-default\">\r\n" + 
				"                                                        <div class=\"panel-heading\">\r\n" + 
				"                                                            <h3 class=\"panel-title\"><strong>Invoice summary</strong></h3>\r\n" + 
				"                                                        </div>\r\n" + 
				"                                                        <div class=\"panel-body\">\r\n" + 
				"                                                            <div class=\"table-responsive\">\r\n" + 
				"                                                                <table class=\"table\">\r\n" + 
				"                                                                    <thead>\r\n" + 
				"                                                                    <tr>\r\n" + 
				"                                                                        <td><strong>Student Name</strong></td>\r\n" + 
				"																		<td class=\"text-center\"><strong>Course</strong></td>\r\n" + 
				"                                                                        <td class=\"text-center\"><strong>Quantity</strong></td>\r\n" + 
				"                                                                        <td class=\"text-right\"><strong>Price</strong></td>\r\n" + 
				"                                                                    </tr>\r\n" + 
				"                                                                    </thead>\r\n" + 
				"                                                                    <tbody>\r\n" + 
				"                                                                    <!-- foreach ($order->lineItems as $line) or some such thing here -->\r\n" + 
				"                                                                    <tr>\r\n" + 
				"                                                                        <td>Emily Kraft</td>\r\n" + 
				"																		<td class=\"text-center\">Microsoft Access 101</td>\r\n" + 
				"                                                                        <td class=\"text-center\">1</td>\r\n" + 
				"                                                                        <td class=\"text-right\">$95.00</td>\r\n" + 
				"                                                                    </tr>\r\n" + 
				"                                                                    <tr>\r\n" + 
				"                                                                        <td>${student.firstName} ${student.lastName}</td>\r\n" + 
				"																		<td class=\"text-center\">${course.courseTitle}</td>\r\n" + 
				"                                                                        <td class=\"text-center\">1</td>\r\n" + 
				"                                                                        <td class=\"text-right\">$${course.price}</td>\r\n" + 
				"                                                                    </tr>\r\n" + 
				"                                                                    <tr>\r\n" + 
				"                                                                        <td>${student.firstName} ${student.lastName}</td>\r\n" + 
				"																		<td class=\"text-center\">${course.courseTitle}</td>\r\n" + 
				"                                                                        <td class=\"text-center\">1</td>\r\n" + 
				"                                                                        <td class=\"text-right\">$${course.price}</td>\r\n" + 
				"                                                                    </tr>\r\n" + 
				"                                                                    <tr>\r\n" + 
				"                                                                        <td>${student.firstName} ${student.lastName}</td>\r\n" + 
				"																		<td class=\"text-center\">${course.courseTitle}</td>\r\n" + 
				"                                                                        <td class=\"text-center\">1</td>\r\n" + 
				"                                                                        <td class=\"text-right\">$${course.price}</td>\r\n" + 
				"                                                                    </tr>\r\n" + 
				"                                                                    <tr>\r\n" + 
				"                                                                        <td class=\"no-line\"></td>\r\n" + 
				"                                                                        <td class=\"no-line\"></td>\r\n" + 
				"                                                                        <td class=\"no-line text-center\">\r\n" + 
				"                                                                            <strong></strong></td>\r\n" + 
				"                                                                        <td class=\"no-line text-right\"></td>\r\n" + 
				"                                                                    </tr>\r\n" + 
				"                                                                    <tr>\r\n" + 
				"                                                                        <td class=\"no-line\"></td>\r\n" + 
				"                                                                        <td class=\"no-line\"></td>\r\n" + 
				"                                                                        <td class=\"no-line text-center\">\r\n" + 
				"                                                                            <strong>Total</strong></td>\r\n" + 
				"                                                                        <td class=\"no-line text-right\"><h4 class=\"m-0\">$${invoice.total}</h4></td>\r\n" + 
				"                                                                    </tr>\r\n" + 
				"                                                                    </tbody>\r\n" + 
				"                                                                </table>\r\n" + 
				"                                                            </div>\r\n" + 
				"                                                        </div>\r\n" + 
				"                                                    </div>\r\n" + 
				"\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div> <!-- end row -->\r\n" + 
				"                                        </div> <!-- panel body -->\r\n" + 
				"                                    </div> <!-- end panel -->\r\n" + 
				"\r\n" + 
				"                                </div> <!-- end col -->\r\n" + 
				"\r\n" + 
				"                            </div>\r\n" + 
				"                            <!-- end row -->\r\n" + 
				"\r\n" + 
				"                        </div><!-- container -->\r\n" + 
				"\r\n" + 
				"                    </div> <!-- Page content Wrapper -->\r\n" + 
				"\r\n" + 
				"                </div> <!-- content -->\r\n" + 
				"\r\n" + 
				"            </div>\r\n" + 
				"            <!-- End Right content here -->\r\n" + 
				"\r\n" + 
				"        </div>\r\n" + 
				"        <!-- END wrapper -->\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </body>\r\n" + 
				"</html>";
}
	
}
