import datetime
from random import randint
from random import choice


WEEKDAYS = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']


def get_rand_pattern():
    patterns = [
        '{0:02d}/{1:02d}/{2:04d} {3}\n',
        '{0:02d}/{1:0d}/{2:04d} {3}\n',
        '{2:04d}-{1:02d}-{0:02d} {3}\n',
        '{3} {0:02d}.{1:02d}.{2:04d}\n',
        '{0:02d}, {1:02d}, {2:04d} {3}\n'
    ]

    return choice(patterns)


def generateDates(n):
    current_date = datetime.date(1850, 1, 1)

    with open('InputData.txt', 'w') as f:

        for i in range(n):
            current_date += datetime.timedelta(days=randint(45, 180))

            new_line = get_rand_pattern().format(
                current_date.day,
                current_date.month,
                current_date.year,
                WEEKDAYS[current_date.weekday()]
            )

            f.write(new_line)


if __name__ == '__main__':
    generateDates(int(input('Number of dates to be generated: ')))
