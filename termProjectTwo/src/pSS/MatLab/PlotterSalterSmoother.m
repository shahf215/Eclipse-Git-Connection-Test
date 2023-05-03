% Define the variables
m = 2;
b = 1;
x = 1:100;
salt_range = [0.0, 10.0]; % configurable range for salt values
window_size = 5; % window size for smoothing the salted values

% Calculate the values of y
y = m*x + b;

% Salt the data by adding or subtracting a random value from y
salted_y = y + (2*randi([0 1], size(y))-1) .* (salt_range(1) + (salt_range(2) - salt_range(1)) * rand(size(y)));

% Smooth the data using the window
smoothed_y = movmean(salted_y, window_size);

% Plot the initial data, salted data, and smoothed data on the same graph
figure;
plot(x, y, 'b-', x, salted_y, 'r-', x, smoothed_y, 'g-');
legend('Inital Data', 'Salted Data', 'Smoothed Data');
title('Initial, Salted, & Smoothed Line Using Y = m * X + b');
xlabel('x');
ylabel('y');