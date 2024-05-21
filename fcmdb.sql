

-- To initialize beginnig database
CREATE TABLE CreditCards (
    CreditCardNumber VARCHAR(16) PRIMARY KEY,
     Password VARCHAR(20),
    Balance FLOAT
 );


 INSERT INTO CreditCards (CreditCardNumber, Password, Balance)
 VALUES
     ('1234567812345678', 'pass1', 500.00),
     ('8765432187654321', 'pass2', 1000.00),
     ('5678123456781234', 'pass3', 750.00),
     ('4321876543218765', 'pass4', 200.00),
    ('9876543298765432', 'pass5', 1500.00);

