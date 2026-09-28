# Spring Boot Cron Expression

## 📌 What is a Cron Expression?

A **Cron Expression** is a time-based scheduling pattern that tells Spring Boot **when a task should execute**.

In Spring Boot, it is commonly used with:

```java
@Scheduled(cron = "...")
```

Example:

```java
@Scheduled(cron = "0 0 10 * * *")
public void runTask() {
    System.out.println("Task executed");
}
```

This executes the method **every day at 10:00 AM**.

---

# 🧩 Spring Boot Cron Syntax

Spring Boot uses **6 fields**:

```text
Second  Minute  Hour  Day-of-Month  Month  Day-of-Week
   ↓       ↓      ↓        ↓           ↓         ↓
   *       *      *        *           *         *
```

### Field Order

| Position | Field | Allowed Values |
|---|---|---|
| 1 | Second | `0-59` |
| 2 | Minute | `0-59` |
| 3 | Hour | `0-23` |
| 4 | Day of Month | `1-31` |
| 5 | Month | `1-12` |
| 6 | Day of Week | `0-7` |

> `0` and `7` can represent Sunday.

---

# ⭐ Easy Trick

Remember:

```text
S M H D M W
```

Where:

```text
S → Seconds
M → Minutes
H → Hours
D → Day
M → Month
W → Week
```

---

# 🔣 Cron Special Characters

## 1. `*` — Every Value

`*` means **every possible value**.

```text
* * * * * *
```

Spring:

```java
@Scheduled(cron = "* * * * * *")
```

Runs every second.

---

## 2. `/` — Every N Values

`/` represents a **step**.

### Every 5 minutes

```text
0 */5 * * * *
```

Runs at:

```text
00
05
10
15
20
25
30
35
40
45
50
55
```

### Every 10 seconds

```text
*/10 * * * * *
```

Runs at:

```text
00
10
20
30
40
50
```

---

## 3. `,` — Multiple Values

`,` means **multiple selected values**.

Example:

```text
0 0 9,18 * * *
```

Runs at:

```text
09:00 AM
06:00 PM
```

every day.

---

## 4. `-` — Range

`-` means a **range**.

Example:

```text
0 0 9 * * MON-FRI
```

Runs at:

```text
Monday
Tuesday
Wednesday
Thursday
Friday
```

at 9:00 AM.

---

# 🔥 Important Examples

## Every minute

```text
0 * * * * *
```

---

## Every 5 minutes

```text
0 */5 * * * *
```

---

## Every 15 minutes

```text
0 */15 * * * *
```

---

## Every hour

```text
0 0 * * * *
```

---

## Every 2 hours

```text
0 0 */2 * * *
```

---

## Every day at midnight

```text
0 0 0 * * *
```

---

## Every day at 10 AM

```text
0 0 10 * * *
```

---

## Every day at 6:30 PM

```text
0 30 18 * * *
```

---

## Every Monday at 9 AM

```text
0 0 9 * * MON
```

---

## Monday to Friday at 9 AM

```text
0 0 9 * * MON-FRI
```

---

## Saturday and Sunday at 10 AM

```text
0 0 10 * * SAT,SUN
```

---

## First day of every month at 10 AM

```text
0 0 10 1 * *
```

---

## 15th day of every month at 10 AM

```text
0 0 10 15 * *
```

---

## December 31 at midnight

```text
0 0 0 31 12 *
```

Runs every year on:

```text
December 31, 00:00:00
```

---

## Every day at 9 AM and 6 PM

```text
0 0 9,18 * * *
```

---

## Every 4 hours

```text
0 0 */4 * * *
```

---

# 🎯 Start Value + Step

You can also use:

```text
START/STEP
```

Example:

```text
5/9 * * * * *
```

This means:

> Start at second `5`, then execute every `9` seconds.

Execution:

```text
05
14
23
32
41
50
59
```

Then the next minute starts again.

### Difference

```text
*/9
```

Starts from the beginning:

```text
0, 9, 18, 27, 36, 45, 54
```

While:

```text
5/9
```

Starts from `5`:

```text
5, 14, 23, 32, 41, 50, 59
```

---

# 🆚 `fixedRate` vs `fixedDelay` vs `cron`

Spring Boot provides different ways to schedule tasks.

### `fixedRate`

```java
@Scheduled(fixedRate = 5000)
```

Runs based on a fixed interval from the **start of the previous execution**.

```text
START ─── 5 sec ─── START ─── 5 sec ─── START
```

---

### `fixedDelay`

```java
@Scheduled(fixedDelay = 5000)
```

Waits for the specified time **after the previous execution finishes**.

```text
START ── execution ── FINISH ── 5 sec ── START
```

---

### `cron`

```java
@Scheduled(cron = "0 0 10 * * *")
```

Runs according to a **calendar/time pattern**.

```text
Every day → 10:00 AM
```

### Easy Difference

```text
fixedRate  → Every X time
fixedDelay → X time after completion
cron       → Specific time/date pattern
```

---

# 🛠️ Complete Spring Boot Example

```java
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    @Scheduled(cron = "0 */5 * * * *")
    public void runTask() {
        System.out.println("Task executed every 5 minutes");
    }
}
```

Enable scheduling:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

---

# ⚠️ Invalid Cron Examples

Spring Boot expects **6 fields**.

### Too few fields

```text
0 0 10 * *
```

❌ Only 5 fields.

### Too many fields

```text
0 0 10 * * * *
```

❌ 7 fields.

### Invalid hour

```text
0 0 25 * * *
```

❌ Hour must be `0-23`.

### Invalid minute

```text
0 60 10 * * *
```

❌ Minute must be `0-59`.

### Invalid second

```text
60 0 10 * * *
```

❌ Second must be `0-59`.

### Invalid month

```text
0 0 10 * 13 *
```

❌ Month must be `1-12`.

### Invalid day

```text
0 0 10 0 * *
```

❌ Day of month must normally be `1-31`.

### Invalid step

```text
0 */0 * * * *
```

❌ Step cannot be zero.

---

# ❓ What About `?`

`?` means:

> **No specific value / don't care**

It is primarily associated with **Quartz cron expressions**.

Example:

```text
0 0 10 ? * MON
```

The `?` means that the **day-of-month is not specifically selected**; the schedule is based on Monday.

For normal Spring Boot `@Scheduled` learning, focus on:

```text
*
/
,
-
```

You generally don't need to memorize `?`.

---

# 🆚 Cron Expression vs Cron Job

They are related but not exactly the same.

### Cron Expression

Defines **WHEN** the task should run.

```text
0 0 10 * * *
```

### Cron Job

The actual task configured with a schedule.

Conceptually:

```text
Cron Job = Cron Expression + Task
```

Example:

```text
0 0 10 * * * + backupDatabase()
```

---

# 🧠 Quick Revision

### Six fields

```text
S M H D M W
```

### Operators

```text
*      → Every
*/N    → Every N
,      → Multiple / OR
-      → Range / TO
```

### Examples

```text
0 */5 * * * *       → Every 5 minutes

0 0 * * * *         → Every hour

0 0 10 * * *        → Every day at 10 AM

0 0 9 * * MON-FRI   → Weekdays at 9 AM

0 0 10 1 * *        → 1st day of every month at 10 AM

0 0 0 31 12 *       → December 31 at midnight
```

## ⭐ Golden Rule

> **Don't memorize cron expressions. Remember the 6 positions and build the expression according to the requirement.**

```text
Second → Minute → Hour → Day → Month → Week
```