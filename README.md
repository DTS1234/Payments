# Payments
Practical programming excercise

Client supports three diferent types of payment: by credit card, by PayPal, and by cash. 
All payments have a transaction ID, the amount of the sale, and a boolean feld that determines (once the
payment has been processed) whether the payment is valid. 

- Credit card payments will also have a MERCHANT_ID constant that allows the bank to
identify each retailer (in our case it is “1111-22”), the card number and its end month and
year.
- PayPal payments will have the username and password of the customer that have done the
payment.
- Payments by cash do not defne any extra felds or methods. 

For payments made with credit card we will delegate on an external payment gateway
provided by our bank (Caja Rural, through its online platform “ruralvía”). Keep in mind that
this is another piece of software independent of our application, and therefore does not know
anything about our specifc Payment objects. What they do, then, for allowing any other
software to be integrated with their system, is to defne a Transaction type that contains all
the method needed by the PaymentGateway class

The way of working of the gateway is as follows: it has an isValid method which receives a
Transaction object and checks that the number and end date of the credit card are valid.
This PaymentGateway class, however, is already fully implemented and you do not have to
do anything with it. What you must do is, frst, to create the mentioned Transaction type
with the following methods (in a real case, Transaction would have been also provided by
our bank, but this is an exam and now you are requested to put yourself for a moment in the
“ruralvía” developers’ shoes).

PayPal Payments

In the case of PayPal payments, as it happened with credit card payments, our application will
collaborate with some external software; in this case, the PayPal API, which is represented by
the PayPalAPI class. But PayPal has followed a slightly diferent approach for its API: now,
instead of having to implement any other type, our PayPal payments simply have to
instantiate an object of that PayPalAPI class and directly invoking its methods.
The process of checking whether a PayPal payment is valid is as follows:

  - A logIn method is invoked, passing the username and password as parameters. If they are
  right this method generates a random session token that will be use in the rest of methods
  of PayPalAPI class to verify that the user is logged. That string token is stored in a list of
  session tokens inside the PayPalAPI object and also returned by this method. If the
  username or password were not right, a PayPalAPI.INVALID_LOGIN string is returned
  instead.
  
  - Then, a checkout method is called passing to it the previously generated token as well as
  the ID and amount of the transaction. If the received token is in the list of session tokens then
  the transaction is valid and returns true; otherwise, it returns false to signal that the payment
  could not be made.
  
Payments by Cash
Finally, payments made by cash are always valid (their process method only have to print a
message indicating that the payment has been made and return true). 

