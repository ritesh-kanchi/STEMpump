# Block 1
import matplotlib.pyplot as plt
import tensorflow as tf

# Block 2
import numpy as np
import logging
logger = tf.get_logger()
logger.setLevel(logging.ERROR)

# Block 3
celsius_q = np.array([-40, -10,  0,  8, 15, 22,  38],  dtype=float)
fahrenheit_a = np.array([-40,  14, 32, 46, 59, 72, 100],  dtype=float)

for i, c in enumerate(celsius_q):
    print("{} degrees Celsius = {} degrees Fahrenheit".format(
        c, fahrenheit_a[i]))

# Block 4
l0 = tf.keras.layers.Dense(units=1, input_shape=[1])

# Block 5
model = tf.keras.Sequential([l0])

# Block 6
model.compile(loss='mean_squared_error',
              optimizer=tf.keras.optimizers.Adam(0.1))

# Block 7
history = model.fit(celsius_q, fahrenheit_a, epochs=1000, verbose=True)
print("Finished training the model")

# Block 8
plt.xlabel('Epoch Number')
plt.ylabel("Loss Magnitude")
plt.plot(history.history['loss'])

# Block 9
print(model.predict([40]))

# Block 10
print("These are the layer variables: {}".format(l0.get_weights()))
