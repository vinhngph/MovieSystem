import random
import string

#function to generata randomly customer
def generate_random_customer(): 
    names = ["Huy", "Vinh", "Nguyên", "Trâm", "Nghĩa", "Ân", "Thảo", "Hương", "Anh", "Đức", "Dũng"]

    name = random.choice(names)

    username = name.lower() + ''.join(random.choice(string.ascii_lowercase + string.digits) for _ in range(3))
    
    customer_age = random.randint(10, 45)
    
    phone_number = ''.join(random.choice(string.digits) for _ in range(10))
    
    customer = {
        "name": name,
        "username": username,
        "customer_age": customer_age,
        "phone_number": phone_number
    }
    
    return customer

#function to generate random password for user
def generate_password(username):
    
    random_chars_digits = ''.join(random.choice(string.ascii_letters + string.digits) for _ in range(5))

    password = username + random_chars_digits
    
    return password


#print the results
random_customer = generate_random_customer()
print("Random Customer:", random_customer)

random_password = generate_password(random_customer["username"])
print("Random Password:", random_password)