def factorial(numero):
    print("0! = 1")

    for i in range(1, numero+1):
        factorial = 1
        j=i
        while(j != 0):
            factorial = factorial * j
            j -= 1
        print(f"{i}! = {factorial}")