CREATE TABLE loan_application (
                                  id UUID PRIMARY KEY,
                                  first_name VARCHAR(32) NOT NULL, -- [cite: 21]
                                  last_name VARCHAR(32) NOT NULL,  -- [cite: 22]
                                  personal_code VARCHAR(11) NOT NULL, -- [cite: 23]
                                  loan_amount DECIMAL(19, 2) NOT NULL, -- [cite: 27]
                                  loan_period_months INT NOT NULL, -- [cite: 24]
                                  interest_margin DECIMAL(5, 3) NOT NULL, -- [cite: 25]
                                  base_interest_rate DECIMAL(5, 3) NOT NULL, -- [cite: 26]
                                  status VARCHAR(20) NOT NULL, -- [cite: 5, 6, 15, 16]
                                  created_at TIMESTAMP NOT NULL
);