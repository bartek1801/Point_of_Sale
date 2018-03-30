# Point_of_Sale

Implementation a simple point of sale

1) single product sale: products bar code is scanned and:
    – if the product is found in products database then it's name and price is printed on LCD display
    – if the product is not found then error message 'Product not found' is printed on LCD display
    – if the code scanned is empty then error message 'Invalid bar-code' is printed on LCD display

2) when 'exit' is input then receipt is printed on printer containing a list of all previously
scanned items names and prices as well as total sum to be paid for all items; the total sum
is also printed on LCD display

3) Devices
    – one input device: bar codes scanner
    – two output devices: LCD display and printer